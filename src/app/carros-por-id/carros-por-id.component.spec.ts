import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarrosPorIdComponent } from './carros-por-id.component';

describe('CarrosPorIdComponent', () => {
  let component: CarrosPorIdComponent;
  let fixture: ComponentFixture<CarrosPorIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CarrosPorIdComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarrosPorIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
