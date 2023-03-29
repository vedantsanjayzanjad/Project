import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { UserRolesModule } from 'src/app/models/user-roles/user-roles.module';
import { UserModule } from 'src/app/models/user/user.module';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor() { }

  admin: UserRolesModule = new UserRolesModule()

  ngOnInit(): void {
    let data = JSON.parse(localStorage.getItem("role") as any)
    console.log(JSON.stringify(data));
    this.admin = data
  }
}