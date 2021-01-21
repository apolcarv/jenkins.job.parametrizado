job('ejemplo-job-DSL') {
  	description('Job DSL de ejemplo para el curso de Jenkins')
  scm {
    git('https://github.com/macloujulian/jenkins.job.parametrizado.git','main') { node ->
      node / gitConfigName('apolcarv1')
      node / gitConfigEmail('alejandropolocarvajal@gmail.com')
    }
  }
  parameters {
      stringParam('nombre', defaultValue = 'Alejandro', description = 'Parametro de cadena para el job Booleano')
      choiceParam('planeta', ['Mercurio','venus','tierra','martes','jupiter','saturno','urano','neptuno'])
  	  booleanParam('agente', false)	
  }
  triggers {
      cron('H/7 * * * *')
  }
  steps {
     shell("bash jobscript.sh")
  }
  publishers {
      mailer('alejandropolocarvajal@gmail.com', true, true)
  }  
}
