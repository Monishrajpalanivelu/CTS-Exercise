import { Component, OnInit, OnDestroy } from '@angular/core'; // <-- Import the hooks
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  imports: [FormsModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit, OnDestroy { // <-- Implement the interfaces
  portalName = 'Student Course Portal';
  isPortalActive = true;
  message = '';
  searchTerm = '';

  // 1. ngOnInit: Runs once after the component's inputs are initialized
  ngOnInit() {
    // We will simulate fetching courses for now
    console.log('HomeComponent initialised — courses loaded');
  }

  // 2. ngOnDestroy: Runs once right before the component is destroyed
  ngOnDestroy() {
    console.log('HomeComponent destroyed');
  }

  onEnrollClick() {
    this.message = 'Enrollment opened!';
  }
}
