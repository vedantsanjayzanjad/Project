import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskModule } from 'src/app/models/task/task.module';
import { UserModule } from 'src/app/models/user/user.module';
import { TaskService } from 'src/app/Services/taskservice/task.service';
import { UserServiceService } from 'src/app/Services/userservice/user-service.service';

@Component({
  selector: 'app-assigntask',
  templateUrl: './assigntask.component.html',
  styleUrls: ['./assigntask.component.css']
})
export class AssigntaskComponent implements OnInit {
  id: number = 0;

  task: TaskModule = new TaskModule();

  user: UserModule[] = [];

  selectedUser!: UserModule;


  toNumber() {
    this.selectedUser = this.selectedUser;
    console.log(this.selectedUser);
  }



  constructor(private taskService: TaskService, private userService: UserServiceService, private snack: MatSnackBar, private router: Router, public route: ActivatedRoute) { }
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

    this.getAllUser()
  }

  getAllUser() {
    this.userService.getAllUser().subscribe(
      (data: any) => {
        console.log(data);
        this.user = data;
      }
    )
  }


  assignTask() {
    //this.selectedUser = this.task.user.username
    console.log(this.selectedUser);
    this.task.user = this.selectedUser;
    console.log(this.task);
    this.taskService.createTaskAndUser(this.task).subscribe
      (
        (data: any) => {
          console.log(data)
          this.snack.open("Successfully Assign !! ", '',
            {
              duration: 3000,
              verticalPosition: 'top',
            });
          this.router.navigateByUrl("/userTask")
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

  //console.log(this.selectedUser);
  //   // // if (this.task.taskId === 0) {
  //   // //   this.taskService.createTaskAndUser(this.task).subscribe
  //   // //     (
  //   // //       (data: any) => {
  //   // //         console.log(data)
  //   // //         this.snack.open("Successfully Assign !! ", '',
  //   // //           {
  //   // //             duration: 3000,
  //   // //             verticalPosition: 'top',
  //   // //           });
  //   // //       },
  //   // //       (error) => {
  //   // //         console.log(error)
  //   // //         this.snack.open("SomeThing Went Wrong !! ", '',
  //   // //           {
  //   // //             duration: 3000,
  //   // //             verticalPosition: 'top',
  //   // //           });
  //   // //       }
  //   // //     )
  //   // }
  //   else {

  //     this.taskService.updateTask(this.task).subscribe
  //       (
  //         (data: any) => {
  //           console.log(data)
  //           {
  //             this.snack.open("Successfully Updated !! ", '',
  //               {
  //                 duration: 3000,
  //                 verticalPosition: 'top',
  //               });
  //           }
  //         },
  //         (error) => {
  //           console.log(error)
  //           this.snack.open("SomeThing Went Wrong !! ", '',
  //             {
  //               duration: 3000,
  //               verticalPosition: 'top',
  //             });
  //         }
  //       )
  //   }
  // }

}



