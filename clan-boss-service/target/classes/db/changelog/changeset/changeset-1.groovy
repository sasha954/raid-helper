package db.changelog.changeset

databaseChangeLog {
    changeSet(id: '2024-03-20-01', author: 'Oleksandr Fomenko') {
        comment('Create table for clan boss.')

        createTable(tableName: 'clan_boss') {
            column(name: 'boss_id', type: 'varchar(128)') {
                constraints(nullable: false)
            }
            column(name: 'name', type: 'varchar(128)') {
                constraints(nullable: false)
            }
            column(name: 'location', type: 'varchar(128)') {
                constraints(nullable: false)
            }
        }
    }
}
