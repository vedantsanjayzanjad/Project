import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserRolesModule } from '../user-roles/user-roles.module';
import { TaskModule } from '../task/task.module';

@NgModule({
  declarations: [],
  imports: [CommonModule],
})
export class UserModule {
  id: number = 122;

  firstName: string = '';

  lastName: string = '';

  username: string = '';

  password: string = '';

  email: string = '';

  phone: string = '';

  address: string = '';

  userRoles = new Set<UserRolesModule>();

  task = new Set<TaskModule>();
}
