package hospital;
/**
 * in hospital v3, I tried not use queue to deal with this problem
 * @author rencongtang
 *
 */
public class Patient implements Comparable {
    private String name;
    private int diseaseLevel;
    private boolean Single;
    public Patient(String name,int diseaseLevel,boolean Single) {
        this.name = name;
        this.diseaseLevel = diseaseLevel;
        this.Single = Single;
    }
    private void setName(String newName){
        this.name = newName;
    }
    private void setDiseaseLevel(int diseaseLevel){
        this.diseaseLevel = diseaseLevel;
    }
    private void setSingle(boolean Single){
        this.Single = Single;
    }
    public String getName() {
        return name;
    }
    public int getDiseaseLevel(){
        return diseaseLevel;
    }
    public boolean getSingle() {
        return Single;
    }
    public String toString(){
        String s=name;
        return s;
    }
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }
}

