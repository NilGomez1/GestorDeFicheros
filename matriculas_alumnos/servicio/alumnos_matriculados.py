import os
from dominio.alumno import Alumno

class AlumnosMatriculados:
    ruta_archivo = "alumnos.txt"

    @staticmethod
    def matricular_alumno(alumno: Alumno):
        with open(AlumnosMatriculados.ruta_archivo, "a", encoding="utf-8") as f:
            f.write(alumno.nombre + "\n")
        print(f"\n✅ Alumno '{alumno.nombre}' matriculado correctamente.\n")

    @staticmethod
    def listar_alumnos():
        if not os.path.exists(AlumnosMatriculados.ruta_archivo):
            print("\n⚠️ No hay alumnos matriculados aún.\n")
            return

        with open(AlumnosMatriculados.ruta_archivo, "r", encoding="utf-8") as f:
            alumnos = f.readlines()

        if alumnos:
            print("\n📋 Alumnos matriculados:")
            for alumno in alumnos:
                print(" -", alumno.strip())
            print()
        else:
            print("\n⚠️ No hay alumnos registrados.\n")

    @staticmethod
    def eliminar_alumnos():
        if os.path.exists(AlumnosMatriculados.ruta_archivo):
            os.remove(AlumnosMatriculados.ruta_archivo)
            print("\n🗑️ Archivo de alumnos eliminado correctamente.\n")
        else:
            print("\n⚠️ No existe el archivo de alumnos.\n")
