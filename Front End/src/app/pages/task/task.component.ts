import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TaskModule } from 'src/app/models/task/task.module';
import { TaskService } from 'src/app/Services/taskservice/task.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  constructor(private taskService: TaskService, private router: Router) { }
  task: TaskModule[] = [];


  ngOnInit(): void {
    this.taskService.getAllTask()
      .subscribe(
        {
          next: (data) => {
            console.log();
            this.task = data
            console.log(JSON.stringify(this.task));
          }
        });
  }

  delete(taskId: number) {
    console.log(taskId);
    this.taskService.delete(taskId)
      .subscribe({
        next: (data) => {
          this.task = data
          console.log(this.task);
          location.reload();
        }
      });

  }
}
