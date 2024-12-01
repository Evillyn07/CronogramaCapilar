package com.amandarezende.cronogramacapilar.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    version = 2,
    entities = [Ativos::class, Cabelo::class, Cronograma::class, Etapa::class, Notificacao::class, Perfil::class, Produto::class],
    exportSchema = true,
)
abstract class CronoAppDatabase : RoomDatabase() {
    abstract fun cronoDao(): DataBaseDao
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(1, 'Glicerina', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(2, 'Aloe Vera', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(3, 'Vitamina C', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(4, 'Banana', ''Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(5, 'Ácido Hialurônico', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(6, 'Pantenol', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(7, 'Extrato de Aveia', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(8, 'Extrato de Ginseng', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(9, 'Extrato de Pêssego', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(10, 'Extrato de Maçã', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(11, 'Extrato de Alfarrobeira', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(12, 'Proteína Hidrolisada da Soja', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(13, 'Óleo de Semente de Tomate', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(14, 'Óleo de Palma', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(15, 'Óleo de Coco', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(16, 'Óleo de Jojoba', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(17, 'Óleo de Avelã', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(18, 'Aminoácidos Funcionais', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(19, 'Manteiga de Oliva', 'Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(20, 'Manteiga de Karité', Hidratação')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(21, 'Óleo de Girassol', 'Nutrição')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(22, 'Óleo de Avelã', 'Nutrição')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(23, 'Óleo de Pracaxi', 'Nutrição')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(24, 'Óleo de Abacate', 'Nutrição')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(25, 'Óleo de Argan', 'Nutrição')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(26, 'Óleo de Semente de Uva', 'Nutrição')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(27, 'Óleo de Coco', 'Nutrição')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(28, 'Manteiga de Karité', 'Nutrição')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(29, 'Manteiga de Cupuaçu', 'Nutrição')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(30, 'Manteiga de Murumuru', 'Nutrição')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(31, 'Manteiga de Cacau', 'Nutrição')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(32, 'Colágeno', 'Reconstrução')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(33, 'Queratina', 'Reconstrução')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(34, 'Arginina', 'Reconstrução')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(35, 'Creatina', 'Reconstrução')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(36, 'Aminoácidos', 'Reconstrução')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(37, 'Ceramidas', 'Reconstrução')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(38, 'Proteínas', 'Reconstrução')")
        db.execSQL("INSERT INTO Produto (id, nome, marca, etapa) VALUES(1, 'Mask', 'Inoar','Hidratação')")
        db.execSQL("INSERT INTO Produto (id, nome, marca, etapa) VALUES(2, 'Morte Súbita', 'Lola','Hidratação')")
        db.execSQL("INSERT INTO Produto (id, nome, marca, etapa) VALUES(3, 'Net Mask', 'Truss','Hidratação')")
        db.execSQL("INSERT INTO Produto (id, nome, marca, etapa) VALUES(4, 'Professionals Oil Reflections Luminous Reboost', 'Wella','Hidratação')")
        db.execSQL("INSERT INTO Produto (id, nome, marca, etapa) VALUES(5, 'Be(M)dita Ghee Hidratação', 'Lola','Hidratação')")
        db.execSQL("INSERT INTO Produto (id, nome, marca, etapa) VALUES(6, 'Invigo Nutri-Enrich', 'Wella','Nutrição')")
        db.execSQL("INSERT INTO Produto (id, nome, marca, etapa) VALUES(7, 'Elixir Ultime', 'Kérastase','Nutrição')")
        db.execSQL("INSERT INTO Produto (id, nome, marca, etapa) VALUES(8, 'Oil Reflections', 'Wella','Nutrição')")
        db.execSQL("INSERT INTO Produto (id, nome, marca, etapa) VALUES(9, 'Miracle Mask', 'Truss','Nutrição')")
        db.execSQL("INSERT INTO Produto (id, nome, marca, etapa) VALUES(10, 'Be(M)dita Ghee Nutrição', 'Lola','Nutrição')")
        db.execSQL("INSERT INTO Produto (id, nome, marca, etapa) VALUES(11, 'Fusion', 'Wella','Reconstrução')")
        db.execSQL("INSERT INTO Produto (id, nome, marca, etapa) VALUES(12, 'Deep Reconstrutor', 'K.Pro','Reconstrução')")
        db.execSQL("INSERT INTO Produto (id, nome, marca, etapa) VALUES(13, 'Resistance', 'Kérastase','Reconstrução')")
        db.execSQL("INSERT INTO Produto (id, nome, marca, etapa) VALUES(14, 'Match Science Reconstrução', 'OBoticário','Reconstrução')")
        db.execSQL("INSERT INTO Produto (id, nome, marca, etapa) VALUES(15, 'Be(M)dita Ghee Reconstrução', 'Lola','Reconstrução')")
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(32, 'Colágeno', 'Reconstrução')")

    }
}