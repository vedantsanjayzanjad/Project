import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminComponent } from './pages/admin/admin.component';
import { UserComponent } from './pages/user/user.component';
import { MatListModule } from '@angular/material/list';
import { MatSidenavModule } from '@angular/material/sidenav';
import { SidenavComponent } from './components/sidenav/sidenav.component';
import { AdminDetailsComponent } from './pages/admin/admin-details/admin-details.component';
import { MatTableModule } from '@angular/material/table';
import { UserModule } from './models/user/user.module';
import { UserRolesModule } from './models/user-roles/user-roles.module';
import { MatPaginator } from '@angular/material/paginator';
import { HolidaysComponent } from './pages/admin/holidays/holidays/holidays.component';
import { HolidayModule } from './models/holiday/holiday.module';
import { AddholidaysComponent } from './pages/admin/holidays/holidays/addholidays/addholidays.component';
import { UpdateHolidayComponent } from './pages/admin/holidays/holidays/update-holiday/update-holiday.component';
import { TaskComponent } from './pages/task/task.component';
import { AddTaskComponent } from './pages/task/add-task/add-task.component';
import { EditTaskComponent } from './pages/task/edit-task/edit-task.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { TaskuserComponent } from './pages/task/taskuser/taskuser.component';
import { AssigntaskComponent } from './pages/task/taskuser/assigntask/assigntask.component';
import { RoleModule } from './models/role/role.module';
import { UserAssignTaskComponent } from './pages/user/user-assign-task/user-assign-task.component';





@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    LoginComponent,
    SignupComponent,
    AdminComponent,
    UserComponent,
    SidenavComponent,
    AdminDetailsComponent,
    HolidaysComponent,
    AddholidaysComponent,
    UpdateHolidayComponent,
    TaskComponent,
    AddTaskComponent,
    EditTaskComponent,
    TaskuserComponent,
    AssigntaskComponent,
    UserAssignTaskComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatSnackBarModule,
    HttpClientModule,
    FormsModule,
    MatListModule,
    MatSidenavModule,
    MatTableModule,
    MatDatepickerModule,
    MatNativeDateModule,
    ReactiveFormsModule

  ],
  providers: [
    UserModule,
    UserRolesModule,
    RoleModule
    // HolidayModule
  ],
  bootstrap: [AppComponent],
})
export class AppModule { }
