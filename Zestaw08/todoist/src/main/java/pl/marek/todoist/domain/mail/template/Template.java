package pl.marek.todoist.domain.mail.template;

public enum Template {

    DONE("done.vm"),
    UNDONE("undone.vm"),
    NEW("new.vm");

    private final String path;

    Template(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
