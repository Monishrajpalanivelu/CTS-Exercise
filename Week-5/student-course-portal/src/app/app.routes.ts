import { Routes } from '@angular/router';

import { Home } from './pages/home/home';
import { CourseList } from './pages/course-list/course-list';
import { StudentProfile } from './pages/student-profile/student-profile';
import { CourseRegistration } from './pages/course-registration/course-registration';

export const routes: Routes = [
  { path: '', component: Home },
  { path: 'courses', component: CourseList },
  { path: 'profile', component: StudentProfile },
  { path: 'register', component: CourseRegistration }
];
