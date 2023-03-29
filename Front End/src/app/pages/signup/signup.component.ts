import { Component, Injectable, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { UserModule } from 'src/app/models/user/user.module';
import { UserServiceService } from 'src/app/Services/userservice/user-service.service';
import Swal from 'sweetalert2';
// import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  ngOnInit(): void {

  }

  constructor(
    private userService: UserServiceService,
    private snack: MatSnackBar,
    private router: Router
  ) { }
  user: UserModule = new UserModule();


  formSubmit() {
    this.userService.registerUser(this.user).subscribe(
      (data: any) => {
        console.log(data + "Info");
        alert("Successfully Registered !! " + this.user.username)
        this.router.navigateByUrl("")
      },
      (error) => {
        console.log(error);
        this.snack.open('SomeThing Went Wrong !! ', '', {
          duration: 3000,
          verticalPosition: 'top',
        });
      }
    );
  }
  data(data: any) {
    throw new Error('Method not implemented.');
  }
}
