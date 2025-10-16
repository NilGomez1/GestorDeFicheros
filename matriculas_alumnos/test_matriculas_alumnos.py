from dominio.alumno import Alumno
from servicio.alumnos_matriculados import AlumnosMatriculados

def mostrar_menu():
    print("===== MENÚ PRINCIPAL =====")
    print("1) Matricular alumno")
    print("2) Listar alumnos")
    print("3) Eliminar archivo de alumnos")
    print("4) Salir")
    print("===========================")

def ejecutar_menu():
    while True:
        mostrar_menu()
        opcion = input("Seleccione una opción: ")

        if opcion == "1":
            nombre = input("\nIngrese el nombre del alumno: ")
            alumno = Alumno(nombre)
            AlumnosMatriculados.matricular_alumno(alumno)

        elif opcion == "2":
            AlumnosMatriculados.listar_alumnos()

        elif opcion == "3":
            AlumnosMatriculados.eliminar_alumnos()

        elif opcion == "4":
            print("\n👋 Saliendo del sistema... ¡Hasta pronto!\n")
            break

        else:
            print("\n❌ Opción no válida. Intente nuevamente.\n")

if __name__ == "__main__":
    ejecutar_menu()
