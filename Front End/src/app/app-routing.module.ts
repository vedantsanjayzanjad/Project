import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDetailsComponent } from './pages/admin/admin-details/admin-details.component';
import { AdminComponent } from './pages/admin/admin.component';
import { AddholidaysComponent } from './pages/admin/holidays/holidays/addholidays/addholidays.component';
import { HolidaysComponent } from './pages/admin/holidays/holidays/holidays.component';
import { UpdateHolidayComponent } from './pages/admin/holidays/holidays/update-holiday/update-holiday.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { AddTaskComponent } from './pages/task/add-task/add-task.component';
import { EditTaskComponent } from './pages/task/edit-task/edit-task.component';
import { TaskComponent } from './pages/task/task.component';
import { AssigntaskComponent } from './pages/task/taskuser/assigntask/assigntask.component';
import { TaskuserComponent } from './pages/task/taskuser/taskuser.component';
import { UserAssignTaskComponent } from './pages/user/user-assign-task/user-assign-task.component';
import { UserComponent } from './pages/user/user.component';

const routes: Routes =
  [
    {
      path: "signup",
      component: SignupComponent,
      pathMatch: 'full'
    },
    {
      path: "",
      component: LoginComponent,
      pathMatch: 'full'
    },
    {
      path: "admin",
      component: AdminComponent,
      pathMatch: 'full'
    },
    {
      path: "normal",
      component: UserComponent,
      pathMatch: 'full'
    },
    {
      path: "adminDetails",
      component: AdminDetailsComponent,
      pathMatch: 'full'
    },
    {
      path: "holidays",
      component: HolidaysComponent,
      pathMatch: 'full'
    },
    {
      path: "addHolidays",
      component: AddholidaysComponent,
      pathMatch: 'full'
    },
    {
      path: "updateHoliday/:id",
      component: UpdateHolidayComponent,
      pathMatch: 'full'
    },
    {
      path: "task",
      component: TaskComponent,
      pathMatch: 'full'
    },
    {
      path: "addTask",
      component: AddTaskComponent,
      pathMatch: 'full'
    },
    {
      path: "updateTask/:id",
      component: EditTaskComponent,
      pathMatch: 'full'
    },
    {
      path: "userTask",
      component: TaskuserComponent,
      pathMatch: 'full'
    },
    {
      path: "assignTask/:id",
      component: AssigntaskComponent,
      pathMatch: 'full'
    },
    {
      path: "userAssignedTask",
      component: UserAssignTaskComponent,
      pathMatch: 'full'
    },
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
