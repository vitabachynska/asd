package packageFiles;

public abstract class ReportGenerator {
    public final void generate() {
        collectData();
        formatReport();
    }
    protected abstract void collectData();
    protected abstract void formatReport();

}
