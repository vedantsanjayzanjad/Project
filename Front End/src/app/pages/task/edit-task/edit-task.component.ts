import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskModule } from 'src/app/models/task/task.module';
import { TaskService } from 'src/app/Services/taskservice/task.service';

@Component({
  selector: 'app-edit-task',
  templateUrl: './edit-task.component.html',
  styleUrls: ['./edit-task.component.css']
})
export class EditTaskComponent implements OnInit {

  id: number = 0;

  task: TaskModule = new TaskModule();

  constructor(private taskService: TaskService, private snack: MatSnackBar, private router: Router, public route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params["id"];
    console.log("router param id is :: " + this.id);
    if (this.id > 0) {
      this.taskService.findTaskById(this.id)
        .subscribe(
          (data: any) => {
            console.log('data is renderd', data)
            this.task = data
            console.log(this.task, 'assigned data to doc')

          },
          (error) => {
            console.log(error)

          }
        );
    }
  }

  add() {
    if (this.task.taskId === 0) {
      this.taskService.addTask(this.task).subscribe
        (
          (data: any) => {
            console.log(data)
            this.snack.open("Successfully Submitted !! ", '',
              {
                duration: 3000,
                verticalPosition: 'top',
              });
          },
          (error) => {
            console.log(error)
            this.snack.open("SomeThing Went Wrong !! ", '',
              {
                duration: 3000,
                verticalPosition: 'top',
              });
          }
        )
    }
    else {

      this.taskService.updateTask(this.task).subscribe
        (
          (data: any) => {
            console.log(data)
            {
              this.snack.open("Task Update Successfully !! ", '',
                {
                  duration: 3000,
                  verticalPosition: 'top',
                });
            }
            this.router.navigateByUrl("/task")
          },
          (error) => {
            console.log(error)
            this.snack.open("SomeThing Went Wrong !! ", '',
              {
                duration: 3000,
                verticalPosition: 'top',
              });
          }
        )
    }

  }


}
