import { Component, OnInit } from '@angular/core';
import { TaskModule } from 'src/app/models/task/task.module';
import { UserRolesModule } from 'src/app/models/user-roles/user-roles.module';
import { UserServiceService } from 'src/app/Services/userservice/user-service.service';

@Component({
  selector: 'app-user-assign-task',
  templateUrl: './user-assign-task.component.html',
  styleUrls: ['./user-assign-task.component.css']
})
export class UserAssignTaskComponent implements OnInit {

  constructor(public user: UserRolesModule, public userService: UserServiceService) { }
  task!: TaskModule[];

  ngOnInit(): void {
    let data = JSON.parse(localStorage.getItem("role") as any)
    console.log(JSON.stringify(data));
    this.user = data;


    this.userService.getTaskByUser(this.user.user.id)
      .subscribe(
        {
          next: (data) => {
            console.log();
            this.task = data
            console.log(JSON.stringify(this.task));
          }
        });
  }
}


