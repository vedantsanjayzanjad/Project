import { Component, OnInit } from '@angular/core';
import { TaskModule } from 'src/app/models/task/task.module';
import { UserRolesModule } from 'src/app/models/user-roles/user-roles.module';
import { UserModule } from 'src/app/models/user/user.module';
import { UserServiceService } from 'src/app/Services/userservice/user-service.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(public user: UserRolesModule, public userService: UserServiceService) { }
  task: TaskModule = new TaskModule();

  ngOnInit(): void {
    let data = JSON.parse(localStorage.getItem("role") as any)
    console.log(JSON.stringify(data));
    this.user = data;
  }
}

