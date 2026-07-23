import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card'; // <-- Import the card
import { HighlightDirective } from '../../directives/highlight.directive';
import { CourseService } from '../../services/course.service';

@Component({
  selector: 'app-course-list',
  imports: [CourseCard, CommonModule, HighlightDirective], // <-- Add it to imports
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {
  isLoading = true;

  courses: { id: number, name: string, code: string, credits: number, gradeStatus: 'passed' | 'failed' | 'pending' }[] = [];
  
  selectedCourseId: number | null = null;

  constructor(private cdr: ChangeDetectorRef, private courseService: CourseService) {}

  ngOnInit() {
    setTimeout(() => {
      this.courses = this.courseService.getCourses();
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
