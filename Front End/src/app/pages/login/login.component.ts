import { JsonPipe } from '@angular/common';
import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { UserRolesModule } from 'src/app/models/user-roles/user-roles.module';
import { UserModule } from 'src/app/models/user/user.module';
import { AuthLoginService } from 'src/app/Services/auth-login.service';
import { UserServiceService } from 'src/app/Services/userservice/user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private loginService: AuthLoginService,
    private snack: MatSnackBar, private router: Router,) { }

  user: UserModule = new UserModule();
  userRoles: UserRolesModule = new UserRolesModule();


  login() {
    this.loginService.loginByUserRoles(this.user).subscribe(
      (data: any) => {
        this.userRoles = data;
        console.log("from here 1", JSON.stringify(this.userRoles));
        console.log(JSON.stringify(this.userRoles.role.roleName));
        localStorage.setItem('role', JSON.stringify(this.userRoles))
        if (this.userRoles.role.roleName == "Admin") {
          this.snack.open('Login Successfully!! ', '', {
            duration: 3000,
            verticalPosition: 'top',
          });
          this.router.navigateByUrl("admin")
        }

        if (this.userRoles.role.roleName == "Normal") {
          this.snack.open('Login Successfully!! ', '', {
            duration: 3000,
            verticalPosition: 'top',
          });
          this.router.navigateByUrl("normal")
        }
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
}
