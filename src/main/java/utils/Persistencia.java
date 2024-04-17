package utils;


import co.edu.uniquindio.reservasevento.model.Agencia;
import co.edu.uniquindio.reservasevento.model.Empleado;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {


        //bancoUq/src/main/resources/persistencia/archivoClientes.txt
        public static final String RUTA_ARCHIVO_CLIENTES = "src/main/resources/persistencia/archivoClientes.txt";
        public static final String RUTA_ARCHIVO_EMPLEADOS = "src/main/resources/persistencia/archivoEmpleados.txt";
        public static final String RUTA_ARCHIVO_USUARIOS = "/src/main/resources/persistencia/archivoUsuarios.txt";
        public static final String RUTA_ARCHIVO_LOG = "src/main/resources/persistencia/log/BancoLog.txt";
        public static final String RUTA_ARCHIVO_OBJETOS = "co.edu.uniquindio.programacion3/src/main/resources/persistencia/archivoObjetos.txt";
        public static final String RUTA_ARCHIVO_MODELO_BANCO_BINARIO = "src/main/resources/persistencia/model.dat";
        public static final String RUTA_ARCHIVO_MODELO_BANCO_XML = "src/main/resources/persistencia/model.xml";
//	C:\td\persistencia



        public static void cargarDatosArchivos(Agencia agencia) throws FileNotFoundException, IOException {
            //cargar archivo de clientes


            //cargar archivos empleados

            ArrayList<Empleado> empleadosCargados = cargarEmpleados();
            if (empleadosCargados.size() > 0) {
                agencia.getListaEmpleados().addAll(empleadosCargados);
            }
        }
            // Cargar empleados desde un archivo
            public static ArrayList<Empleado> cargarEmpleados() throws FileNotFoundException, IOException {
                ArrayList<Empleado> empleados = new ArrayList<>();
                ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_EMPLEADOS);
                for (String linea : contenido) {
                    String[] datos = linea.split(",");
                    Empleado empleado = new Empleado(datos[0], datos[1], datos[2], datos[3], datos[4]);
                    empleados.add(empleado);
                }
                return empleados;
            }


    /**
         * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
         * @param
         * @param
         * @throws IOException

        public static void guardarClientes(ArrayList<Empleado> listaClientes) throws IOException {
            // TODO Auto-generated method stub
            String contenido = "";
            for(Empleado empleado:listaClientes)
            {
                contenido+= cliente.getNombre()+","+cliente.getApellido()+","+cliente.getCedula()+","+cliente.getDireccion()
                        +","+cliente.getCorreo()+","+cliente.getFechaNacimiento()+","+cliente.getTelefono()+"\n";
            }
            ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contenido, false);
        }
     */

        public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados) throws IOException {
            String contenido = "";
            for(Empleado empleado:listaEmpleados)
            {
                contenido+= empleado.getNombre()+
                        ","+empleado.getEventosAsiganados()+
                        ","+empleado.getId()+
                        ","+empleado.getCorreoElectronico()+"\n";
            }
            ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
        }



//	----------------------LOADS------------------------

        /**
         *
         * @param
         * @param
         * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
         * @throws FileNotFoundException
         * @throws IOException
         */
        public static ArrayList<Empleado> cargarClientes() throws FileNotFoundException, IOException
        {
            ArrayList<Empleado> empleados =new ArrayList<Empleado>();
            ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_CLIENTES);
            String linea="";
            for (int i = 0; i < contenido.size(); i++)
            {
                linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
                Empleado empleado = new Empleado("Luisa","23223","luisa@","nada",null);
                empleado.setNombre(linea.split(",")[0]);
                empleado.setEventosAsiganados(linea.split(",")[1]);
                empleado.setId(linea.split(",")[2]);
                empleado.setCorreoElectronico(linea.split(",")[3]);

               empleados.add(empleado);
            }
            return empleados;
        }

/**
        public static ArrayList<Empleado> cargarEmpleados() throws FileNotFoundException, IOException {
            ArrayList<Empleado> empleados =new ArrayList<Empleado>();
            ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_EMPLEADOS);
            String linea="";
            for (int i = 0; i < contenido.size(); i++)
            {
                linea = contenido.get(i);
                Empleado empleado = new Empleado();
                empleado.setNombre(linea.split(",")[0]);
                empleado.setApellido(linea.split(",")[1]);
                empleado.setCedula(linea.split(",")[2]);
                empleado.setFechaNacimiento(linea.split(",")[3]);
                empleados.add(empleado);
            }
            return empleados;
        }





        public static boolean iniciarSesion(String usuario, String contrasenia) throws FileNotFoundException, IOException, UsuarioExcepcion {

            if(validarUsuario(usuario,contrasenia)) {
                return true;
            }else {
                System.out.println();("Usuario no existe");
            }

        }

        private static boolean validarUsuario(String usuario, String contrasenia) throws FileNotFoundException, IOException
        {
            ArrayList<Usuario> usuarios = Persistencia.cargarUsuarios(RUTA_ARCHIVO_USUARIOS);

            for (int indiceUsuario = 0; indiceUsuario < usuarios.size(); indiceUsuario++)
            {
                Usuario usuarioAux = usuarios.get(indiceUsuario);
                if(usuarioAux.getUsuario().equalsIgnoreCase(usuario) && usuarioAux.getContrasenia().equalsIgnoreCase(contrasenia)) {
                    return true;
                }
            }
            return false;
        }

        public static ArrayList<Usuario> cargarUsuarios(String ruta) throws FileNotFoundException, IOException {
            ArrayList<Usuario> usuarios =new ArrayList<Usuario>();

            ArrayList<String> contenido = ArchivoUtil.leerArchivo(ruta);
            String linea="";

            for (int i = 0; i < contenido.size(); i++) {
                linea = contenido.get(i);

                Usuario usuario = new Usuario();
                usuario.setUsuario(linea.split(",")[0]);
                usuario.setContrasenia(linea.split(",")[1]);

                usuarios.add(usuario);
            }
            return usuarios;
        }

**/
//	----------------------SAVES------------------------

        /**
         * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
         * @param
         * @param ruta
         * @throws IOException
         */

        public static void guardarObjetos(ArrayList<Empleado> listaClientes, String ruta) throws IOException  {
            String contenido = "";

            for(Empleado clienteAux:listaClientes) {
                contenido+= clienteAux.getNombre()+","+clienteAux.getCorreoElectronico()+","+clienteAux.getId()+clienteAux.getEventosAsiganados()
                        ;
            }
            ArchivoUtil.guardarArchivo(ruta, contenido, true);
        }





        //------------------------------------SERIALIZACIÓN  y XML


        public static Agencia cargarRecursoBancoBinario() {

            Agencia agencia= null;

            try {
                agencia = (Agencia) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_BANCO_BINARIO);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return agencia;
        }

    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
    {
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }

        public static void guardarRecursoBancoBinario(Agencia agencia) {
            try {
                ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_BANCO_BINARIO, agencia);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        public static Agencia cargarRecursoBancoXML() {

           Agencia agencia = null;

            try {
                agencia = (Agencia) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BANCO_XML);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return agencia;

        }



        public static void guardarRecursoBancoXML(Agencia agencia) {

            try {
                ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BANCO_XML, agencia);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }










    }

