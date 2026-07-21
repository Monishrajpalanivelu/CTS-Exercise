import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';

@Component({
  selector: 'app-course-card',
  imports: [CommonModule, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard implements OnChanges {
  @Input() course!: { id: number, name: string, code: string, credits: number, gradeStatus: 'passed' | 'failed' | 'pending' }; 
  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;
  isEnrolled = false;

  // Getters keep templates clean by moving complex conditional logic out of the HTML
  get cardClasses() {
    return {
      'card--enrolled': this.isEnrolled,
      'card--full': this.course.credits >= 4,
      'expanded': this.isExpanded
    };
  }

  enrollCourse() {
    this.isEnrolled = true;
    this.enrollRequested.emit(this.course.id);
  }

  ngOnChanges(changes: SimpleChanges) {
    console.log('Course changed!', changes);
  }
}
