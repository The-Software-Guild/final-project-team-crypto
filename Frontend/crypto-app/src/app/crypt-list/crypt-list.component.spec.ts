import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CryptListComponent } from './crypt-list.component';

describe('CryptListComponent', () => {
  let component: CryptListComponent;
  let fixture: ComponentFixture<CryptListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CryptListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CryptListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
