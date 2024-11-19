import {NgModule} from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatFormFieldModule} from '@angular/material/form-field';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';





const material = [
  MatToolbarModule, 
  MatButtonModule,
  MatInputModule,
  MatExpansionModule,
  MatFormFieldModule,
  BrowserModule,
  ReactiveFormsModule
];

@NgModule({
  exports: [material],
  imports: [material]
})
export class MaterialModule { }
