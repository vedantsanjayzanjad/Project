import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserModule } from '../user/user.module';
import { RoleModule } from '../role/role.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class UserRolesModule {
  userRoleId: number = 0;

  user: UserModule = new UserModule()

  role: RoleModule = new RoleModule()
}
