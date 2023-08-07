# Sistema de Gestión de Historia Clinica 

## Integrantes
- Willbert Manuel Gamboa Campos
- Ariel Jesus Fernandez Mena
- Oscar Daniel Moreno Flores
- Wilder Manuel Turriza Poot
---
# Json de las peticiones  

## Ficha de identificación:  
localhost:8081/crp/paciente/
```json
{
    "fechaCreacion":[
        2010,
        5,
        14
    ],
    "nombre":"Nombre",
    "apellido":"Apellido",
    "fechaNacimiento":[
        2000,
        1,
        1
    ],
    "direccion":"Calle 7, #2B, x 2 y 8, Colonia Montebello",
    "telefono":9991111111,
    "email":"nombre.apellido@gmail.com",
    "estadoCivil":"soltero",
    "escolaridad":"bachillerato",
    "ocupacion": "pintor"

}
``` 

## Antecedentes Heredo Familiares:  
localhost:8081/crp/AHF/
```json
{
    "paciente":{
        "numExpediente":1,
        "fechaCreacion":[
            2001,
            4,
            11
        ],
        "nombre":"Enrique",
        "apellido":"Rodriguez",
        "fechaNacimiento":[
            2001,
            1,
            1
        ],
        "direccion":"Calle 7, #2B, x 2 y 8, Colonia Montebello",
        "telefono":9991111111,
        "email":"nombre.apellido@gmail.com",
        "estadoCivil":"soltero",
        "escolaridad":"bachillerato",
        "ocupacion": "pintor"
    },
    "cardiopatias":"ninguno",
    "alergias":"ninguno",
    "diabetes":"ninguno",
    "nefropatias":"ninguno",
    "psiquiatricos":"ninguno",
    "neurologicas":"ninguno",
    "otros":"ninguno"
}
```
## Antecedentes Personales No Patologicos:  
localhost:8081/crp/APNP/
```json
{
    "paciente":{
        "numExpediente":1,
        "fechaCreacion":[
            2010,
            4,
            11
        ],
        "nombre":"Nombre",
        "apellido":"Apellido",
        "fechaNacimiento":[
            2001,
            1,
            1
        ],
        "direccion":"Calle 7, #2B, x 2 y 8, Colonia Montebello",
        "telefono":9991111111,
        "email":"nombre.apellido@gmail.com",
        "estadoCivil":"soltero",
        "escolaridad":"bachillerato",
        "ocupacion": "pintor"
    },
    "habitosPersonales":"8 horas de sueno",
    "bano":"diario",
    "habitacion":"1 recamara",
    "alcoholismo":"semanal",
    "vacunas":"covid",
    "tabaquismo":"no",
    "actividadFisica":"1 hora semanal",
    "alimentacion":"3000 cal",
    "zoonosis":"ninguno"
}
```
## Antecedentes Personales Patológicos:  
localhost:8081/crp/APP/
```json
{
    "ahf":{
        "id":1,
        "paciente":{
            "numExpediente":1,
            "fechaCreacion":[
                2010,
                4,
                1
            ],
            "nombre":"Nombre",
            "apellido":"Apellido",
            "fechaNacimiento":[
                2001,
                1,
                1
            ],
            "direccion":"Calle 7, #2B, x 2 y 8, Colonia Yucatan",
            "telefono":9991111111,
            "email":"nombre.apellido@gmail.com",
            "estadoCivil":"soltero",
            "escolaridad":"bachillerato",
            "ocupacion": "pintor"
        },
        "cardiopatias":"ninguno",
        "alergias":"ninguno",
        "diabetes":"ninguno",
        "nefropatias":"ninguno",
        "psiquiatricos":"ninguno",
        "neurologicas":"ninguno",
        "otros":"ninguno"
    },
    "cirugias":"ninguno",
    "adicciones":"ninguno",
    "traumatismos":"ninguno",
    "enfermedadesTransmicionSexual":"ninguno",
    "padecimientosArticulares":"ninguno"

}
```
## Antecedentes Gineco Obstetricos:  
localhost:8081/crp/AGO/
```json
{
    "paciente":{
        "numExpediente": 1,
        "fechaCreacion":[
            2000,
            5,
            14
        ],
        "nombre":"Nombre",
        "apellido":"Apellido",
        "fechaNacimiento":[
            2001,
            1,
            1
        ],
        "direccion":"Calle 7, #2B, x 2 y 8, Colonia Montebello",
        "telefono":9991111111,
        "email":"nombre.apellido@gmail.com",
        "estadoCivil":"soltero",
        "escolaridad":"doctorado",
        "ocupacion": "pintor"

    },
    "menarca":[
        2009,
        11,
        3
    ],
    "ritmoMenstrual":"regular",
    "ipsa":23,
    "numPartos":0,
    "fup":[
        2018,
        2,
        1
    ],
    "abortos":0,
    "cesareas":0
}
```
## Antecedentes Perinatales:  
localhost:8081/crp/AP/
```json
{
    "paciente":{
        "numExpediente": 1,
        "fechaCreacion":[
            2000,
            5,
            14
        ],
        "nombre":"Nombre",
        "apellido":"Apellido",
        "fechaNacimiento":[
            2001,
            1,
            1
        ],
        "direccion":"Calle 7, #2B, x 2 y 8, Colonia Montebello",
        "telefono":9991111111,
        "email":"nombre.apellido@gmail.com",
        "estadoCivil":"soltero",
        "escolaridad":"doctorado",
        "ocupacion": "pintor"

    },
    "sdg":2,
    "apgar":9,
    "peso":1.8,
    "talla":49,
    "numEmbarazo":1,
    "problemaParto":"ninguno"
}
```
## Padecimiento Actual:  
localhost:8081/crp/PA/
```json
{
    "paciente":{
        "numExpediente": 1,
        "fechaCreacion":[
            2000,
            5,
            14
        ],
        "nombre":"Nombre",
        "apellido":"Apellido",
        "fechaNacimiento":[
            2001,
            1,
            1
        ],
        "direccion":"Calle 7, #2B, x 2 y 8, Colonia Montebello",
        "telefono":9991111111,
        "email":"nombre.apellido@gmail.com",
        "estadoCivil":"soltero",
        "escolaridad":"doctorado",
        "ocupacion": "pintor"

    },
    "fecha":[
        2000,
        11,
        9
    ],
    "descripcion":"",
    "evolucion":"ninguno",
    "estadoActual":"ninguno"
}
```
## Agenda:  
localhost:8081/crp/agenda/
```json
{
    "paciente":{
        "numExpediente":1,
        "fechaCreacion":[2001,4,11],
        "nombre":"Enrique",
        "apellido":"Rodriguez",
        "fechaNacimiento":[2001,1,1],
        "direccion":"Calle 7, #2B, x 2 y 8, Colonia Montebello",
        "telefono":9991111111,
        "email":"nombre.apellido@gmail.com",
        "estadoCivil":"soltero",
        "escolaridad":"bachillerato",
        "ocupacion": "pintor"
  },
  "fecha": "2023-08-15",
  "hora": "14:30:00",
  "tipoPaciente": "Inicial",
  "estatusCita": "Agendada",
  "numeroSesion": 1,
  "costoTerapia": 150.50
}
``` 
---
## Diagrama de microservicios
![Micros](https://github.com/2DMore/sistema-gestion-historia-clinica/assets/90080810/b6f04bc4-29c0-402c-be0a-a538b84fdc03)
---
## Diagrama ER del sistema  
![Diagrama E-R](https://github.com/2DMore/sistema-gestion-historia-clinica/assets/73006726/478cf5f9-821e-48c6-99d1-1637823378f6)

---
  
