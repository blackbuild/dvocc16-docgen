import model.Project
import groovy.xml.MarkupBuilder

MarkupBuilder builder = builder
Project project = element


builder.html {
    head {
        meta(charset: "UTF-8")
        title "Project: $project.name"
    }
    body {
        div(class: "header") {
            a(href: "../../") {
                h2 "Project: $project.name"
            }
            div(class: "creation", "last created: ${new Date()}")
        }
        table {
            tbody {
                tr {
                    td("Project Lead")
                    td(project.lead)
                }
                tr {
                    td("URL")
                    td(project.repositoryUrl)
                }
                tr {
                    td("Maturity")
                    td(project.status.maturity)
                }
            }
        }
        div(class: "footer", "last created: ${new Date()}")
    }
}

