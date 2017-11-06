
class Project {
    
    private String name;
    private String description;

    public Project() { // to create a blank project
    }

    public Project(String projectName) {
        name = projectName; // create project with name
    }

    public Project(String pName, String pDesc) {
        name = pName; // create with name
        description = pDesc; // and desc
    }

    public String elevatorPitch() {
        return name + ": " + description;
    }

    public void setName(String name) {
        this.name = name; // 'this' required to distinguish
    }

    public void setDesc(String desc) {
        description = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }
    
    public static void main(String[] args) {
        Project one = new Project();
        Project two = new Project("Two");
        Project three = new Project("Three", "Pitch");
        one.name = "Secret"; // able to set within class
        two.setDesc("Second"); // must set via method if outside class since member variable is private
        three.elevatorPitch();
        System.out.println("Project Name: " + two.getName() + ", Description: " + two.getDesc());
        
    }
}