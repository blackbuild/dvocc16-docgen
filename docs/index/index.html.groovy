import model.Config
import groovy.xml.MarkupBuilder

MarkupBuilder builder = builder
Config config = model

builder.html {
    head {
        meta(charset: "UTF-8")
        title "Project overview"
    }
    body {
        div(class: "header") {
            h2 "Project overview"
            div(class: "creation", "last created: ${new Date()}")
        }
        ul {
            config.projects.each { name, project ->
                li {
                    a(href: "projects/$project.name", project.name)
                    if (project.disabled) text("disabled")
                }
            }
        }
    }
}