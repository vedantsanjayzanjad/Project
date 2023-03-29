import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAssignTaskComponent } from './user-assign-task.component';

describe('UserAssignTaskComponent', () => {
  let component: UserAssignTaskComponent;
  let fixture: ComponentFixture<UserAssignTaskComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserAssignTaskComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserAssignTaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
