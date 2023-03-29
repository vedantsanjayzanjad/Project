import { NgModule } from '@angular/core';
import { CommonModule, DatePipe, formatDate } from '@angular/common';
import { MatDatepicker } from '@angular/material/datepicker';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class HolidayModule {
  holidayId: number = 0;
  holidayDate: Date = new Date(formatDate(new Date(), 'yyyy/MM/dd', 'en'));
  holidayName: string = '';
}
