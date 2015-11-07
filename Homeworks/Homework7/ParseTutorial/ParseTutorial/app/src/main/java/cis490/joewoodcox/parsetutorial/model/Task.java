package cis490.joewoodcox.parsetutorial.model;

/**
 * Created by Joe Woodcox on 11/7/2015.
 */
public class Task {

    public String taskId;
    public String name;

    public Task(){
        this.taskId = "";
        this.name = "";
    }

    public void setTaskId(String taskId){
        this.taskId = taskId;
    }

    public String getTaskId(){
        return taskId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}