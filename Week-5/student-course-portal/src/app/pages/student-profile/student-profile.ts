import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-student-profile',
  imports: [FormsModule, CommonModule],
  templateUrl: './student-profile.html',
  styleUrl: './student-profile.css',
})
export class StudentProfile {
  onSubmit(form: NgForm) {
    console.log('Form Submitted!', form.value);
    alert('Profile saved successfully!');
  }
}
