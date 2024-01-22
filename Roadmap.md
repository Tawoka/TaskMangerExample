# Task Manager Roadmap

## Version 1 - Elevate your daily experience with this easy-to-use task manager

Finalized

## Version 2 - Supercharge your day with an efficient assistant seamlessly organizing your tasks

The objective of this version is to improve usability and practical value of our task manager. Users have to notice a
significant improvement in their productivity. They should feel relaxed and reassured by the fact that our application
keeps track of all their activities. At the same time we must prevent flooding of tasks for the user. They have to know
that using our application means to have a quick look what's next, without having to search long.

Our new version comes with 2 EPICs:
- Enhance usability and practical value
- Manage data prioritization and visibility

For each epic we have identified a set of features we wish to accomplish:
**EPIC: Enhance usability and practical value**
- Adding Delete All
- Adding new field "Finished By"
  - Synchronization with EPIC 2 required
  - Add Bulk-Action to apply same date to multiple tasks
  - Add date picker
  - Add "quick buttons" in Bulk-Action (e.g. Move back one week, move forward one week)
    - Make buttons Rule-Based so users can configure the buttons for their usual behaviour

**EPIC: Manage data prioritization and visibility**
- Moving finished tasks to secondary table
    - Add Delete All Finished Tasks
    - Replace checkbox with Buttons "Close" and "Reopen" in the respective tables
- Removing priority field
  - Instead, calculate priority through a rule based calculation based on the new field "Finished By"
  - Synchronization with EPIC 1 required
- Add enhanced usage mode for power users (Users with a high volume of tasks)
  - Add Search Field
  - Add Sorting
  - Add Pagination

## Version 3 - Optimize your team's coordination and dazzle with enhanced productivity

The future of the task manager depends on acceptance and user numbers. Any monetization ambition requires a strong and
loyal user base. We achieve this by expanding into the sphere of team work. It is great to organize yourself efficiently.
It is even better to organize your team! For this purpose we need to look towards our future competitors and merge their
solutions with our USP. We will carve out our own market share and grow our brand!

While the road for this version is still foggy, we can clearly see on capability we must create: **Organize a teams work
in a Task Manager both personal, and shared at the same time**

This capability requires 3 EPICs:
- Create accounts to authenticate and authorize
- Enable accounts to share work
- Incorporate office life in our product

We further identified following features for each of these epics.

**EPIC: Create accounts to authenticate and authorize**
- Add Authentication, Users & Roles
  - Roles are ADMIN, MANAGER, EMPLOYEE
- Add an admin panel to configure the application
  - Move all existing rule based configurations to the panel
- Add ability to assign users with role "Employee" to one or many users with role "Manager"

**EPIC: Enable accounts to share work**
- Add feature "Assign" for MANAGERS, so they can assign tasks to EMPLOYEE
  - Add configuration "assign unrestricted", allowing everyone to assign to anyone
  - Add configuration "team assign unrestricted", allowing everyone to assign to anyone with the same manager
  - Make both configurations available for a "per user" basis
- Add feature "Grab" for MANAGERS and EMPLOYEE, so they can grab unassigned tasks for themselves

**EPIC: Incorporate office life in our product**
- Add out of office calendar
  - Add feature to automatically move deadlines
    - To be set before the OoO time
    - To be moved back by the OoO duration
    - To a default date after the vacation (e.g. 5 work days after vacation)
  - Add feature to notify manager of the invalid deadline
  - Add a feature to maintain subs, which are automatically assigned, when OoO events occur
  - Synchronize calendar with HR-System
- Add new field "importance" with level HIGH and LOW