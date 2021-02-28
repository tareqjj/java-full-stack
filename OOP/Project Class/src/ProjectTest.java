public class ProjectTest {
    public static void main(String[] args){
        Project proj1 = new Project("Cars", "Four wheels and four doors", 500.0);
        Project proj2 = new Project("Bike", "Two wheels and no doors", 250.0);
        Project proj3 = new Project("ATV", "Four wheels and no doors", 125.0);

        Portfolio newPortfolio = new Portfolio();
        newPortfolio.setProjects(proj1);
        newPortfolio.setProjects(proj2);
        newPortfolio.setProjects(proj3);

        System.out.println(newPortfolio.getPortfolioCost());
        newPortfolio.showPortfolio();
    }
}
