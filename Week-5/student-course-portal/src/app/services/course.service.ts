import { Injectable } from '@angular/core';

// @Injectable({ providedIn: 'root' }) tells Angular to create a single, shared instance (a singleton)
// of this service that can be injected into any component throughout the entire application.
// This ensures all components share the same state and data.
@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private courses: { id: number, name: string, code: string, credits: number, gradeStatus: 'passed' | 'failed' | 'pending' }[] = [
    { id: 1, name: 'Angular Basics', code: 'CS101', credits: 3, gradeStatus: 'passed' },
    { id: 2, name: 'Advanced Routing', code: 'CS102', credits: 4, gradeStatus: 'pending' },
    { id: 3, name: 'State Management', code: 'CS103', credits: 4, gradeStatus: 'failed' },
    { id: 4, name: 'RxJS Operators', code: 'CS104', credits: 3, gradeStatus: 'passed' },
    { id: 5, name: 'Unit Testing', code: 'CS105', credits: 2, gradeStatus: 'pending' }
  ];

  constructor() { }

  getCourses() {
    return this.courses;
  }
}
