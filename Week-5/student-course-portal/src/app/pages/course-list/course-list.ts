import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card'; // <-- Import the card
import { HighlightDirective } from '../../directives/highlight.directive';

@Component({
  selector: 'app-course-list',
  imports: [CourseCard, CommonModule, HighlightDirective], // <-- Add it to imports
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {
  isLoading = true;

  courses: { id: number, name: string, code: string, credits: number, gradeStatus: 'passed' | 'failed' | 'pending' }[] = [
    { id: 1, name: 'Angular Basics', code: 'CS101', credits: 3, gradeStatus: 'passed' },
    { id: 2, name: 'Advanced Routing', code: 'CS102', credits: 4, gradeStatus: 'pending' },
    { id: 3, name: 'State Management', code: 'CS103', credits: 4, gradeStatus: 'failed' },
    { id: 4, name: 'RxJS Operators', code: 'CS104', credits: 3, gradeStatus: 'passed' },
    { id: 5, name: 'Unit Testing', code: 'CS105', credits: 2, gradeStatus: 'pending' }
  ];
  
  selectedCourseId: number | null = null;

  constructor(private cdr: ChangeDetectorRef) {}

  ngOnInit() {
    setTimeout(() => {
      this.isLoading = false;
      this.cdr.detectChanges(); // <-- Manually trigger change detection
    }, 1500);
  }

  // trackBy improves performance by telling Angular how to uniquely identify each item.
  // When the array changes, Angular only re-renders the items whose trackBy value changed, instead of destroying and re-creating the entire list.
  trackByCourseId(index: number, course: any) {
    return course.id;
  }

  onEnroll(courseId: number) {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }
}
