import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-course-registration',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './course-registration.html',
  styleUrl: './course-registration.css'
})
export class CourseRegistration implements OnInit {
  registrationForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.registrationForm = this.fb.group({
      courseName: ['', [Validators.required, Validators.minLength(5)]],
      courseCode: ['', [Validators.required, Validators.pattern('^[A-Z]{2}[0-9]{3}$')]],
      credits: ['', [Validators.required, Validators.min(1), Validators.max(5)]]
    });
  }

  onSubmit() {
    if (this.registrationForm.valid) {
      console.log('Course Registered Successfully:', this.registrationForm.value);
      alert('Course Registered Successfully!');
      this.registrationForm.reset();
    } else {
      this.registrationForm.markAllAsTouched();
    }
  }
}
