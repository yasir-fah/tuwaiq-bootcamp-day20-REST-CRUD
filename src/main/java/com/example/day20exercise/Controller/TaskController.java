//package com.example.day20exercise.Controller;
//
//import com.example.day20exercise.Api.ApiResponse;
//import com.example.day20exercise.Model.Task;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//
//@RestController
//@RequestMapping("/api/v1/task")
//public class TaskController {
//
//    ArrayList<Task> tasks = new ArrayList<>();
//    int idCounter = 0;
//
//
//    @GetMapping("/get")
//    public ArrayList<Task> getTasks() {
//        return tasks;
//    }
//
//
//    @PostMapping("/post")
//    public ApiResponse addTask(@RequestBody Task task) {
//        task.setId(++idCounter);
//        tasks.add(task);
//
//        return new ApiResponse("tasks added successfully !", "200 ok");
//    }
//
//
//    @PutMapping("/put/{id}")
//    public ApiResponse updateTask(@PathVariable int id, @RequestBody Task task) {
//
//        for (Task t : tasks) {
//            if (t.getId() == id) {
//                tasks.set(tasks.indexOf(t), task);
//                return new ApiResponse("tasks added successfully", "200 ok");
//            }
//        }
//        return new ApiResponse(
//                "Task with id = " + id + " not found",
//                "404 Not Found"
//        );
//    }
//
//
//    @DeleteMapping("/delete/{id}")
//    public ApiResponse deleteTask(@PathVariable int id) {
//
//        for (Task t : tasks) {
//            if (t.getId() == id) {
//                tasks.remove(t);
//                return new ApiResponse("tasks deleted successfully", "200 ok");
//            }
//        }
//        return new ApiResponse(
//                "Task with id = " + id + " not found", "404 Not Found");
//    }
//
//
//    @PutMapping("put/status/{id}")
//    public ApiResponse changeStatus(@PathVariable int id, @RequestBody Task status) {
//
//        for (Task t : tasks) {
//            if (t.getId() == id) {
//                t.setStatus(status.getStatus());
//                return new ApiResponse("tasks changed successfully", "200 ok");
//            }
//        }
//        return new ApiResponse("Task with id = " + id + " not found", "404 Not Found");
//    }
//
//
//    @GetMapping("/get/title/{title}")
//    public ResponseEntity<Task> getById(@PathVariable String title) {
//
//        for(Task task : tasks){
//            if(task.getTitle().equalsIgnoreCase(title)){
//                return ResponseEntity.ok(task);
//            }
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//
//    }
//
//
//
//
//
//
//}
