import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskuserComponent } from './taskuser.component';

describe('TaskuserComponent', () => {
  let component: TaskuserComponent;
  let fixture: ComponentFixture<TaskuserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaskuserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaskuserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
