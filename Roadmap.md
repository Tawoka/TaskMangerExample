# Task Manager Roadmap

## Version 1 - Elevate your daily experience with this easy-to-use task manager

- Add database container to project
- Create executable jar through maven
- Add configuration options for dynamic parameters like database url
- Create proper roadmap for future versions 

## Version 2 - Supercharge your day with an efficient assistant seamlessly organizing your tasks

- Adding Delete All
- Adding new field "Finished By"
  - Replacing free selected priority by rule based calculation days until "finished by"
  - Add Bulk-Action to apply same date to multiple tasks
  - Add date picker
  - Add "quick buttons" in Bulk-Action (e.g. Move back one week, move forward one week)
    - Make buttons Rule-Based so users can configure the buttons for their usual behaviour
- Moving finished tasks to secondary table
    - Add Delete All Finished Tasks
    - Replace checkbox with Buttons "Close" and "Reopen"
- Add Search Field
- Add Sorting
- Add Pagination

## Version 3 - Optimize your team's coordination and dazzle with enhanced productivity

- Add Authentication, Users & Roles
  - Roles are ADMIN, MANAGER, EMPLOYEE
- Add ability to assign users with role "Employee" to one or many users with role "Manager"
- Add new field "importance" with level HIGH and LOW
- Add feature "Assign" for MANAGERS, so they can assign tasks to EMPLOYEE
  - Add configuration "assign unrestricted", allowing everyone to assign to anyone
  - Add configuration "team assign unrestricted", allowing everyone to assign to anyone with the same manager
  - Make both configurations available for a "per user" basis
- Add feature "Grab" for MANAGERS and EMPLOYEE, so they can grab unassigned tasks for themselves
- Add out of office calendar
  - Add feature to automatically move deadlines
    - To be set before the OoO time
    - To be moved back by the OoO duration
    - To a default date after the vacation (e.g. 5 work days after vacation)
  - Add feature to notify manager of the invalid deadline
  - Add a feature to maintain subs, which are automatically assigned, when OoO events occur
  - Synchronize calendar with HR-System