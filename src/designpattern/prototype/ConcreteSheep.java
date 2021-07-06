package designpattern.prototype;

/**
 * 具体的羊
 */
public class ConcreteSheep extends Sheep {
    private final String gene;
    public ConcreteSheep(String gene){
        this.gene = gene;
    }
    @Override
    Sheep cloneOne() {
        return new ConcreteSheep(gene);
    }
    @Override
    public String toString(){
        return gene;
    }

}
