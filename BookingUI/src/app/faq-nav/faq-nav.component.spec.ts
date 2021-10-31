import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FaqNavComponent } from './faq-nav.component';

describe('FaqNavComponent', () => {
  let component: FaqNavComponent;
  let fixture: ComponentFixture<FaqNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FaqNavComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FaqNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
