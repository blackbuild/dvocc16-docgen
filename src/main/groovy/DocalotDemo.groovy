import com.blackbuild.devops.docalot.Docalot
import com.blackbuild.devops.docalot.convert.Single
import com.blackbuild.devops.docalot.convert.Splitted
import com.blackbuild.devops.docalot.data.FlagCollector
import com.blackbuild.devops.docalot.data.PojoCollector
import com.blackbuild.devops.docalot.data.PropertiesCollector
import com.blackbuild.devops.docalot.publish.DirectoryOutput
import model.Config

def model = Config.createFromScript(Model)



Docalot.run {

    gather {
        main(PojoCollector) {
            sourceObject model
            splitter { model.projects }
        }

        domain(PropertiesCollector, 'status') {
            sourceFolder new File("domains/data")
        }
        domain(FlagCollector, 'disabled') {
            sourceFolder new File("domains/data")
        }
    }

    convert {
        baseDir new File("docs")

        directory(Single) {
            source "index"
            target "."
        }
        directory(Splitted) {
            source "projects"
        }
    }

    publish {
        output(DirectoryOutput) {
            target new File("build/html")
        }
    }
}
