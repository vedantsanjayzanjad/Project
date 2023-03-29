import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserRolesModule } from '../user-roles/user-roles.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class RoleModule {
  roleId: number = 0;

  roleName: string = '';

  set = new Set<UserRolesModule>();
}
