import { NgModule } from '@angular/core';
import { CommonModule, formatDate } from '@angular/common';
import { UserModule } from '../user/user.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class TaskModule {
  taskId: number = 0;
  startDate: Date = new Date(formatDate(new Date(), 'yyyy/MM/dd', 'en'));;
  days: number = 0;
  endDate: Date = new Date(formatDate(new Date(), 'yyyy/MM/dd', 'en'));;
  taskDescription: string = ''
  user!: UserModule
}