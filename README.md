# Task Divider

### Video Demo:  
https://www.youtube.com/watch?v=QoK3JMEjaHY&t=1s

### Description:

I decided to create an Android Application called "Task Divider" which divides tasks  for users. This was achieved using Android Studio, XML and Java, I used this as an opportunity to learn XML and Java and create my first mobile application.

![image](https://user-images.githubusercontent.com/652368/141326210-0f12f2ee-b286-44ae-a33e-232f2979ce34.png)

# App breakdown
### Main:

- Makes the Fragment1 show when the app is launched by the user and hides the action bar

### Fragment1:  

- OnClick methods add and store the data to either of the two empty ArrayLists: "users" and "tasks" when buttons clicked
- Return errors if  users does not input at least 1 task and 2 users
- Return errors if empty fields are submitted
- Stores lists in bundles and transitions view to Fragment2 when "continue button" clicked 

### Fragment2:

- Fragment2 receives the "users" and "tasks" lists passed on from Fragment1 and prepares the data
- Calculate() method randomly assigns tasks to users using a 2d Array
- Show the user a ListView of the result of the calculate() method
- Reset everything and go back to Fragment1 by clicking the "reset" button

# Challenges 

One of the main challenges of the project was to make the app have multiple fragments. I had to learn how to store and pass data across multiple fragments, this was ultimately achieved by using Bundles. 

It was also difficult to decide how exactly to divide the tasks between the users. I decided to keep it simple and randomly assign every task to one of the users. In this regard, there is definitely room for improvement with several possible solutions:

- Add minimum and maximum assigned tasks per user depending on total users, spreading the tasks more evenly
- Add weight to inputted tasks based on an estimation of how long they take, avoiding one-sidedness of task distribution
