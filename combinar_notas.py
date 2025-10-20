import csv

DELIMITADOR = ';'
CODIFICACION = 'latin-1'

with open('Notas_Alumnos_UF1.csv', 'r', newline='', encoding=CODIFICACION) as f1:
    lector1 = csv.DictReader(f1, delimiter=DELIMITADOR)
    datos_uf1 = {fila['Id']: fila for fila in lector1}

with open('Notas_Alumnos_UF2.csv', 'r', newline='', encoding=CODIFICACION) as f2:
    lector2 = csv.DictReader(f2, delimiter=DELIMITADOR)
    datos_uf2 = {fila['Id']: fila for fila in lector2}

datos_combinados = []

for id_alumno in datos_uf1:
    nombre = datos_uf1[id_alumno]['Nombre']
    apellidos = datos_uf1[id_alumno]['Apellidos']
    nota_uf1 = datos_uf1[id_alumno]['UF1']
    nota_uf2 = datos_uf2[id_alumno]['UF2']

    datos_combinados.append({
        'Id': id_alumno,
        'Nombre': nombre,
        'Apellidos': apellidos,
        'Nota_UF1': nota_uf1,
        'Nota_UF2': nota_uf2
    })

with open('Notas_Alumnos.csv', 'w', newline='', encoding=CODIFICACION) as salida:
    campos = ['Id', 'Nombre', 'Apellidos', 'Nota_UF1', 'Nota_UF2']
    escritor = csv.DictWriter(salida, fieldnames=campos, delimiter=DELIMITADOR)
    escritor.writeheader()
    escritor.writerows(datos_combinados)

print("Archivo 'Notas_Alumnos.csv' creado correctamente.")
