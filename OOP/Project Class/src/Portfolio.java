import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Project> projects = new ArrayList<Project>();

    public Portfolio(){

    }

    public ArrayList<Project> getProjects(){
        return this.projects;
    }

    public void setProjects(Project newProject){
        this.projects.add(newProject);
    }

    public double getPortfolioCost(){
        double sum = 0.0;
        for (int i = 0; i < this.projects.size(); i++) {
            sum += this.projects.get(i).getInitialCost();
        }
        return  sum;
    }

    public void showPortfolio(){
        for (int i = 0; i < this.projects.size() ; i++) {
            System.out.println(this.projects.get(i).elevatorPitch());
            System.out.println(this.projects.get(i).getInitialCost());
        }
    }

}
