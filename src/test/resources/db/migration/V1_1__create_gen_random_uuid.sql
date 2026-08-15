-- Cria uma função gen_random_uuid() no H2 para tornar as migrações compatíveis
-- Esta migração está apenas em src/test/resources, então será aplicada somente
-- durante testes que usam o classpath de teste (H2).
CREATE ALIAS IF NOT EXISTS gen_random_uuid AS $$
String gen_random_uuid() {
    return java.util.UUID.randomUUID().toString();
}
$$;
