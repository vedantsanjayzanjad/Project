import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { UserRolesModule } from 'src/app/models/user-roles/user-roles.module';
import { UserModule } from 'src/app/models/user/user.module';


@Component({
  selector: 'app-admin-details',
  templateUrl: './admin-details.component.html',
  styleUrls: ['./admin-details.component.css']
})


export class AdminDetailsComponent implements OnInit {
  constructor(public admin: UserRolesModule) { }

  ngOnInit(): void {
    let data = JSON.parse(localStorage.getItem("role") as any)
    console.log(JSON.stringify(data));
    this.admin = data
  }
}





